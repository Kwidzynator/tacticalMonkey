let points = [];
let svgOverlay = document.getElementById("svgOverlay")


const monkeyType = ["Primary", "Military", "Mage", "Support"];
const monkey = ["Dart Monkey", "Boomerang Monkey", "Bomb Shooter", "Tack Shooter",
                         "Ice Monkey", "Glue Gunner"]


document.getElementById("addMapImg").addEventListener('change', function(event){
    const file = event.target.files[0]
    const mapPreview = document.getElementById("previewMap")
    svgOverlay = document.getElementById("svgOverlay")

    if(file){
        const reader = new FileReader();
        reader.onload = function(e){
            clear();
            mapPreview.src = e.target.result;
            mapPreview.onload = function() {
                mapPreview.style.display = 'block';

                svgOverlay.style.display = 'block';
                svgOverlay.style.width = mapPreview.clientWidth + "px";
                svgOverlay.style.height = mapPreview.clientHeight + "px";
                svgOverlay.style.position = "absolute";
                svgOverlay.style.top = mapPreview.offsetTop + "px";
                svgOverlay.style.left = mapPreview.offsetLeft + "px";
            };

        }
        reader.readAsDataURL(file)

    }
    else{
        mapPreview.src = '';
        mapPreview.style.display = 'none'
        svgOverlay.style.display = 'none';
    }

});
function clear(){
    points = [];
    svgOverlay.innerHTML = "";
}
document.getElementById("svgOverlay").addEventListener('click', function (e) {
    const rect = svgOverlay.getBoundingClientRect();
    const x = e.clientX - rect.left;
    const y = e.clientY - rect.top;


    if (x >= 0 && x <= rect.width && y >= 0 && y <= rect.height) {
        console.log(`Kliknięcie w obrębie SVG: X=${x}, Y=${y}`);
        showCategorySelector(x, y);
    } else {
        console.log("Kliknięcie poza obszarem SVG!");
    }
});

function showCategorySelector(x, y) {
    let modal = document.createElement('div');
    setUpModal(modal, x, y);

    const selectType = createSelectOptions(monkeyType);

    const selectMonkey = createSelectOptions(monkey);

    const selectRow1 = createSelectOptions(Array.from({length: 6}, (_, i) => i.toString()));
    const selectRow2 = createSelectOptions(Array.from({length: 6}, (_, i) => i.toString()));
    const selectRow3 = createSelectOptions(Array.from({length: 6}, (_, i) => i.toString()));

    const confirmButton = createButton("dodaj");
    const cancelButton = createButton("anuluj")


    modal.appendChild(selectType);
    modal.appendChild(selectMonkey);
    modal.appendChild(selectRow1);
    modal.appendChild(selectRow2);
    modal.appendChild(selectRow3);
    modal.appendChild(confirmButton);
    modal.appendChild(cancelButton);

    document.body.appendChild(modal);

    confirmButton.addEventListener("click", () => {
        const selectedType = selectType.value;
        const selectedMonkey = selectMonkey.value;
        const selectedRow1 = selectRow1.value;
        const selectedRow2 = selectRow2.value;
        const selectedRow3 = selectRow3.value;

        const monkey = {
            type: selectedType,
            name: selectedMonkey,
            upgrades: {
                upgrade1: selectedRow1,
                upgrade2: selectedRow2,
                upgrade3: selectedRow3,
            }
        }

        points.push({ x, y, monkey: monkey});

        addPointToSVG(x, y, monkey);
        document.body.removeChild(modal);
    });

    cancelButton.addEventListener("click", () => {
        document.body.removeChild(modal);
    });

}

function setUpModal(modal, x, y) {
    const rect = svgOverlay.getBoundingClientRect();
    const globalX = rect.left + window.scrollX + x;
    const globalY = rect.top + window.scrollY + y;

    modal.style.position = "absolute";
    modal.style.left = `${globalX}px`;
    modal.style.top = `${globalY}px`;


    modal.style.backgroundColor = "white";
    modal.style.padding = "10px";
    modal.style.border = "1px solid #ccc";
    modal.style.boxShadow = "0 2px 5px rgba(0, 0, 0, 0.3)";
    modal.style.zIndex = 1000;
}
function createSelectOptions(optionsArray){
    const select = document.createElement("select");
    optionsArray.forEach(optionValue => {
       const option = document.createElement("option");
       option.value = optionValue;
       option.textContent = optionValue;
       select.appendChild(option);

    });
    return select;
}

function createButton(text){
    const button = document.createElement("button");
    button.textContent = text;
    button.style.marginLeft = "10px";
    return button;
}

function addPointToSVG(x, y, monkey) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");

    circle.setAttribute("cx", x);
    circle.setAttribute("cy", y);
    circle.setAttribute("r", 5);

    const monkeyInfo = document.getElementById('monkey-info');
    showMonkeyInfo(monkey, monkeyInfo);


    circle.addEventListener("mouseenter", () => {
        const rect = svgOverlay.getBoundingClientRect();
        const globalX = rect.left + window.scrollX + x;
        const globalY = rect.top + window.scrollY + y;

        monkeyInfo.style.display = "block";
        monkeyInfo.style.position = "absolute";
        monkeyInfo.style.left = `${globalX + 10}px`;
        monkeyInfo.style.top = `${globalY + 10}px`;

        showMonkeyInfo(monkey, monkeyInfo);
    });

    circle.addEventListener("mouseleave", () => {
        monkeyInfo.style.display = "none";
    });

    svgOverlay.appendChild(circle);

}

function showMonkeyInfo(monkey, monkeyInfo){

    monkeyInfo.innerHTML= `
        <p>Typ: ${monkey.type}</p>
        <p>Nazwa: ${monkey.name}</p>
        <p>Ulepszenie 1: ${monkey.upgrades.upgrade1}</p>
        <p>Ulepszenie 2: ${monkey.upgrades.upgrade2}</p>
        <p>Ulepszenie 3: ${monkey.upgrades.upgrade3}</p>
    `;
}

document.addEventListener("DOMContentLoaded", function (){
    const selected = document.getElementById("addMapName");
    fetch("/api/makingPost/maps", {
        method: 'GET',
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data =>{
            Object.entries(data).forEach(([id, name]) => {
                const option = document.createElement("option");
                option.value = id;
                option.textContent = name;
                selected.appendChild(option);
            });
        })
        .catch(error =>{
           console.error("Something went wrong with loading data")
        });
});
