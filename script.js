window.onload = function(){

const form = document.getElementById("dashboardForm");

form.addEventListener("submit", function(e){

e.preventDefault();

let ph = document.getElementById("ph").value;
let turbidity = document.getElementById("turbidity").value;
let oxygen = document.getElementById("oxygen").value;
let temperature = document.getElementById("temperature").value;

let params = new URLSearchParams();

params.append("ph",ph);
params.append("turbidity",turbidity);
params.append("oxygen",oxygen);
params.append("temperature",temperature);

fetch("ServletWater",{
method:"POST",
body:params
})
.then(response => response.json())
.then(data => {

let status = document.getElementById("status");

status.innerText = data.status;

status.className="";

if(data.status.toLowerCase().includes("safe"))
status.classList.add("safe");

else if(data.status.toLowerCase().includes("moderate"))
status.classList.add("moderate");

else
status.classList.add("unsafe");

})
.catch(error=>{
alert("Error connecting to servlet");
console.log(error);
});

});

}
