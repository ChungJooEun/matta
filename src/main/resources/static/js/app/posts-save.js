// datePicker init method
var initDatePicker = function(){
    $("#visitedDate").datepicker({
        nextText: '다음 달',
        prevText: '이전 달',
        showButtonPanel: true,
        closeText: ' x ',
        dateFormat: "yy.mm.dd",
        dayNames: ['월요일','화요일','수요일','목요일','금요일','토요일','일요일'],
        dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
        monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        maxDate: 0,
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
};

var parseToLocalDate = function(){
    return $('#visitedDate').val().replace(/\./gi, "-");
};

// 별점 가져오기
var calcStarRate = function(){
    var starRate = $('.starR.on').last().attr("value");
    return starRate;
};

// 메인
var main = {

    init : function(){
        initDatePicker();

        var _this = this;
        $('#btn-posts-save').on('click',function(){
            _this.save();
        });
    },
    save : function(){
        var requestData = {
            content: $('#content').val(),
            stars: calcStarRate(),
            visitedDate: parseToLocalDate()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(requestData)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error))
        });
    }
};

main.init();