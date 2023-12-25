
let button = document.getElementById("btnRegister")

button.addEventListener("click", event =>{
    registerMovie();
});

let registerMovie = async()=>{


    let fields = {}

    fields.title = document.getElementById("title").value;
    fields.director = document.getElementById("director").value;
    fields.gender = document.getElementById("gender").value;

    const petition = await fetch("http://localhost:8080/api/movies/save",
        {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(fields)
        });

}