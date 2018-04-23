var firmaResponse;
function firmar(texto,response){
    
    console.log(">>>>>>>>>>>>>>"+texto);
    firmaResponse=response;
    appFirma.firmar(texto);
}

function firmarArchivo(response){
    firmaResponse=response;
    appFirma.firmarArchivo();
}

function recibirFirma(firma, nombre){
    setTimeout(function(){firmaResponse(firma,nombre);},200);    
}