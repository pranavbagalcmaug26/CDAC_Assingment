
document.getElementById("lightMode").addEventListener("click",()=>{
    document.body.classList.toggle("dark");
    let button=document.getElementById("lightMode");
    if(document.body.classList.contains("dark")){
        button.innerHTML="Light Mode";
    }else{
        button.innerHTML="Dark Mode";
    }
})
document.getElementById("btnn").addEventListener("click",()=>{
    let name=document.getElementById("inText").value;
    if(name.trim()===""){
        alert("Please enter your name..!");
    }else{
        alert(`welcome ${name}!`);
    }
});

