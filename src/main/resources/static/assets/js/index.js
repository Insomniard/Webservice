var main = {
    init : function (){
        var _this = this;
        $('#btn-registration').on('click',function (){
            _this.save();
        });

    },
    save : function (){
        var data = {
         title : $('#title').val(),
         author: $('#author').val(),
         contents: $('#contents').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/board',
            dataType: 'json',
            contentsType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('작성 완료');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};
main.init();
