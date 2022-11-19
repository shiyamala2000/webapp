var uri = "http://localhost:8080/books/";
var posts =[];

function getAllBooks() {
    alert();
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            posts = JSON.parse(xhttp.responseText);
            console.log(xhttp.responseText);
            displayBooks(posts);
        }
    };
    xhttp.open("GET", uri, true);
    xhttp.send();
}
function displayBooks(data) {
    const tBody = document.getElementById("books");
    tBody.innerHTML = "";
    const button = document.createElement("button");
    data.forEach((item) => {
        let tr = tBody.insertRow();
        let td1 = tr.insertCell(0);
        let title = document.createTextNode(item.title);
        td1.appendChild(title);
        let td2 = tr.insertCell(1);
        let author = document.createTextNode(item.author);
        td1.appendChild(author);
        let td3 = tr.insertCell(2);
        let price = document.createTextNode(item.price);
        td1.appendChild(price);
        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `editItem(${item.id})`);
        let td4 = tr.insertCell(3);
        td4.appendChild(editButton);
        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `deleteItem(${item.id})`);
        let td5 = tr.insertCell(4);
        td4.appendChild(deleteButton);
    });
}
// var uri="http://localhost:8080/books/{id}?id=1";
function save() {
    alert("save");

    var newBook = {
        "id": 0,
        "title": "Shades of Love",
        "author": "Maheesha",
        "price": 2500
    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/books/", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(newBook));
}
function update() {
    alert("update");
    var updateBook = {
        "id": 5,
        "title": "IKIGAI",
        "author": "Francecs Miralles",
        "price": 500
    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/books/{id}?id=1", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(updateBook));
    console.log(updateBook);
}
function del() {
    alert("delete");
    var deleteBook = {
        "id": 7,
        "title": "fromfe",
        "author": "author",
        "price": 500
    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/books/7", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(deleteBook));
}

