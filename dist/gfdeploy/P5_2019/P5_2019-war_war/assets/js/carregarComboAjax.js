//Os Modelos Das Tabelas Ou Entidades Devem Ter "id" e "designacao" 
//function carregarItems(param, url, cmb, idEdit, mult) {
//
//    $.ajax({
//        type: 'GET',
//        url: url,
//        //dataType: 'json',
//        data: param,
//        beforeSend: function() {
//            $(cmb).empty();
//            $(cmb).append("<option value='0'>-- Carregando... --</option>");
//            $(cmb).attr("disabled", true);
//        },
//        success: function(data) {
//
//            $(cmb).empty();
//
//            if (data !== '') {
//
//                if (!mult)
//                    $(cmb).append("<option value='0'>-- Selecione --</option>");
//
//                var h = JSON.parse(data);
//
//                $.each(h, function(i, item) {
//                    $(cmb).append("<option value=" + item[0] + ">" + item[1] + "</option>");
//                });
//
//                if (idEdit !== '' && idEdit !== 0) {
//                    $(cmb).val(idEdit);
//                }
//                
//            }
//            else {
//                $(cmb).append("<option value='0'>-- ERRO AO CARREGAR --</option>");
//            }
//        },
//        complete: function() {
//            $(cmb).removeAttr("disabled");
////            console.log("FimAjaxRequestCombo " + param);
//        },
//        error: function(jqXHR, textStatus, errorThrown) {
//            console.log("Erro param " + param);
//            console.log(jqXHR);
//            console.log(textStatus);
//            console.log(errorThrown);
//
//        }
//
//    });
//}

function carregarItemsCustom(param, url, posValor, posTexto, cmb, idEdit, mult) {

    $.ajax({
        type: 'GET',
        url: url,
        //dataType: 'json',
        data: param,
        beforeSend: function() {
            $(cmb).empty();
            $(cmb).append("<option value='0'>-- Carregando... --</option>");
            $(cmb).attr("disabled", true);
        },
        success: function(data) {
              preencherCombo(cmb, data, posValor, posTexto, idEdit, mult);
            
        },
        complete: function() {
            $(cmb).removeAttr("disabled");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Erro param " + param);
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }

    });
}

function preencherCombo(cmb, dados, posValor, posTexto, idEdit, mult) {

    $(cmb).empty();

    if (dados !== '') {

        if (!mult) $(cmb).append("<option value='0'>-- Selecione --</option>");
        var h = JSON.parse(dados);
        $.each(h, function(i, item) {
            $(cmb).append("<option value=" + item[posValor] + ">" + item[posTexto] + "</option>");
        });

        if (idEdit !== '' && idEdit !== 0) $(cmb).val(idEdit);
    }
    else $(cmb).append("<option value='0'>-- ERRO AO CARREGAR --</option>");

}


function carregarItemsCustomSuccessOut(param, url, posValor, posTexto, cmb, idEdit, mult, fxSuccess) {

    $.ajax({
        type: 'GET',
        url: url,
        //dataType: 'json',
        data: param,
        beforeSend: function() {
            $(cmb).empty();
            $(cmb).append("<option value='0'>-- Carregando... --</option>");
            $(cmb).attr("disabled", true);
        },
        success: fxSuccess,
        complete: function() {
            $(cmb).removeAttr("disabled");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Erro param " + param);
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }

    });
}

$(document).ready(function() {

    $(".btnLoadCombo").click(function(e) {

        e.preventDefault();
        var formGroup = $(this).parent().parent()[0];
        var newElem = formGroup.cloneNode(true);
        $(formGroup).after(newElem);

        $(newElem).remove();
    });

});



