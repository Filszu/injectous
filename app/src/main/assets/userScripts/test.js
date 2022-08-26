//Please read whole file

var tekst = document.createTextNode('Powered by Filszu'); //stworz element txt
var box = document.createElement("DIV");
box.appendChild(tekst);




var b = document.getElementsByTagName("body")[0];
b.appendChild(box);



box.innerHTML='Powered by Filszu -- <a href="https://youtu.be/SUbNp3SP5nc">Darmowa domena i strona www - sprawdĹş</a>';

//---------------------Style_box-----------
box.style.color = "white";
box.style.position = "fixed";
box.style.backgroundColor="rgba(8, 79, 185, 0.911)";

box.style.textAlign="center";
box.style.fontSize="25px";
box.style.fontFamily="'Courier New', Courier, monospace";
box.style.top="0";
box.style.padding= "15px 15px 20px";
box.style.minWidth="50%";
box.style.border="4px solid rgb(2, 30, 71)";
box.style.borderRadius="0px 0px 30% 30%";
box.style.zIndex="20";
box.style.margin="0px auto";
box.style.left="20%";



box.querySelector("a").style.color="rgb(255, 255, 169)";

// ------------------------



// If you don't want my logo watermark paste only that js in your main js

try {
    const toDelete = document.querySelector('img[src="https://cdn.000webhost.com/000webhost/logo/footer-powered-by-000webhost-white2.png"]');
    toDelete.style.display="none";
    console.log('logo has been deleted  [FILSZU]')
  } catch (error) {
    //console.error(error);
    console.log("It's now 000webhost");



}






// If you don't want my logo watermark paste only that css in your main css
/*paste at the end of the css code*/

/*
img[src="https://cdn.000webhost.com/000webhost/logo/footer-powered-by-000webhost-white2.png"] {
    display: none;
}
*/




/*---------------------*/

function subYT(){
    alert("First of all sub my chanel on yt :)");
    alert('just paste this css code\n img[src="https://cdn.000webhost.com/000webhost/logo/footer-powered-by-000webhost-white2.png"] {display: none;}\n\npaste it at the end of the css code');
}

text2 = document.createElement("div");
text2.innerHTML = "<center><p style=\"background-color: yellow;\">To delete my water mark click <a href=\"#\" onclick=\"subYT()\">here</a></p></center>";
b.appendChild(text2);