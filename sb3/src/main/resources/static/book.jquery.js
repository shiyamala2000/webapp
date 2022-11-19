const uri = "http://localhost:8080/books/";
let books = [];
let updateIndex = 0;
function getItems() {
    $.ajax({
        url: "http://localhost:8080/books/",
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            _displayItems(data);
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function saveORupdateItem() {
    //   document.getElementById("myBtn").innerHTML == "Save"
    //     ? addItem()
    //     : updateItem();
    if (document.getElementById("myBtn").innerHTML == "Save") {
        addItem();
    } else {
        updateItem();
    }
}
function addItem() {
    const addNameTextbox = document.getElementById("title");
    const item = {
        id: 0,
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        price: document.getElementById("price").value
    };
    console.log(item);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/books/",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(item),
        success: function (result) {
            getItems();
        },
        error: function (result) {
            alert("msg");
        },
    });
}
function editItem(id) {
    document.getElementById("myBtn").innerHTML = "Update";
    const item = books.find((item) => item.id === id);
    document.getElementById("title").value = item.title;
    document.getElementById("author").value = item.author;
    document.getElementById("price").value = item.price;
    updateIndex = id;
}
function updateItem() {
    const item = {
        id: updateIndex,
        title: document.getElementById("title").value.trim(),
        author: document.getElementById("author").value.trim(),
        price: document.getElementById("price").value.trim(),
    };
    console.log(item);
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/books/" + updateIndex,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(item),
        success: function (result) {
            getItems();
            document.getElementById("myBtn").innerHTML = "Save";
            document.getElementById("title").value = "";
            document.getElementById("author").value = "";
            document.getElementById("price").value = "";
            updateIndex = 0;
        },
        error: function (result) {
            alert("msg");
        },
    });
}
function deleteItem(id) {
    const item = {
        id: id,
        title: document.getElementById("title").value.trim(),
        author: document.getElementById("author").value.trim(),
        price: document.getElementById("price").value.trim(),
    };
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/books/" + id,
        data: JSON.stringify(item),
        success: function (result) {
            getItems();
        },
        error: function (result) {
            alert("msg");
        },
    });
}
function _displayItems(data) {
    const tBody = document.getElementById("books");
    tBody.innerHTML = "";
    const button = document.createElement("button");
    data.forEach((item) => {
        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `editItem(${item.id})`);
        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `deleteItem(${item.id})`);
        let tr = tBody.insertRow();
        let td1 = tr.insertCell(0);
        let title = document.createTextNode(item.title);
        td1.appendChild(title);
        let td2 = tr.insertCell(1);
        let author = document.createTextNode(item.author);
        td2.appendChild(author);
        let td3 = tr.insertCell(2);
        let price = document.createTextNode(item.price);
        td3.appendChild(price);
        let td4 = tr.insertCell(3);
        td4.appendChild(editButton);
        let td5 = tr.insertCell(4);
        td5.appendChild(deleteButton);
    });
    books = data;
}