window.onload = function(){
    listMovies();
}

let listMovies = async()=>{
    const petition = await fetch("http://localhost:8080/api/movies",
        {
            method: "GET",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        });

        const movies = await petition.json();

        let tableContent = "";

        for(let movie of movies){
            let rowContent = `<tr>
                <td>${movie.id}<td>
                <td>${movie.title}<td>
                <td>${movie.director}<td>
                <td>${movie.gender}<td>
                <td>
                    <i onClick="editMovie(${movie.id})" class="material-icons button edit">edit</i>
                    <i onClick="deleteMovie(${movie.id})" class="material-icons button delete">delete</i>
                </td>
            </tr>
            `

            tableContent += rowContent;
        }

        document.querySelector("#table tbody").outerHTML = tableContent

}

        let deleteMovie = async(id)=>{
            const petition = await fetch("http://localhost:8080/api/movies/delete/"+id,
                {
                    method: "DELETE",
                    headers: {
                        "Accept": "application/json",
                        "Content-Type": "application/json"
                    }
                });

    listMovies();
}

let idEdit;

let editMovie = async(id)=>{
    
    shorForm();

    idEdit = id;
    
    const petition = await fetch("http://localhost:8080/api/movies/"+id,
            {
                method: "GET",
                headers: {
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                }
            });

    const movie = await petition.json();

    document.getElementById("title").value=movie.title;
    document.getElementById("director").value=movie.director;
    document.getElementById("gender").value=movie.gender;

    let btnEdit = document.getElementById("btnEdit");

}

btnEdit.addEventListener("click", event=>{
    applyUpdate(idEdit);
})

let applyUpdate = async(id)=>{
    let fields = {};

    fields.id= id;
    fields.title= document.getElementById("title").value;
    fields.director= document.getElementById("director").value;
    fields.gender= document.getElementById("gender").value;

    const petition = await fetch("http://localhost:8080/api/movies/edit",
        {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(fields)
        });

        listMovies();
}

function shorForm(){
    let form = document.getElementById("form").style.visibility="visible";
    return form;
}