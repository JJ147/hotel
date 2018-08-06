layui.use(['table','jquery','form','element','laydate'], function () {

    var table = layui.table;
    var $ = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laydate = layui.laydate;
    var page = layui.laypage
    var exportPower = 0;
    var viewCertifatePower = 0;
    var lastPageSize = 10;
    form.on('submit(questionForm)', function (data) {
        getQuestionMsg(1,lastPageSize)
        return false;
    });
    function getQuestionMsg(pIndex,pSize) {
        layui.jquery.ajax({
            url: '/question/queryQuestion',
            type: "POST",
            dataType: "jsonp",
            data: {
                "tvaId": $('#quesId').val(),
                "dealerFullName": $('#quesType').val(),
                "provinceId": $('#subject').val(),
                "currPage":pIndex,
                "pageSize":pSize
            },
            success: function (result) {
                if (result.code == 0) {

                    //第一个实例
                    table.render({
                        elem: '#pageNums_1'
                        , page: false //开启分页
                        , data: result.data.data
                        , cols: [[ //表头
                            {field: 'quesId', title: '经销商ID', width: 120, sort: true, fixed: 'left'}
                            , {field: 'question', title: '题目', width: 180}
                            , {field: 'answer', title: '答案A', width: 130}
                            , {field: 'answer1', title: '答案B', width: 130}
                            , {field: 'answer2', title: '答案C', width: 130}
                            , {field: 'answer3', title: '答案D', width: 130}
                            , {field: 'quesType', title: '题型', width: 180}
                            , {field: 'subject', title: '科目', width: 80}
                            ,{title: '答题解析', width:100,fixed:"right",align:"center", templet:"#preBar"}
                        ]]
                        , limits: [10, 15, 20]
                        , limit: pSize //每页默认显示的数量
                    });
                    totalCount= result.count
                    page.render({
                        elem: "pageNums_2"  //'pageNums'
                        , count: totalCount
                        ,limit:pSize
                        ,prev:'上一页'
                        ,next:'下一页'
                        , limits: [10, 15, 20]
                        ,layout:['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                        , curr: location.hash.replace('#!fenye=', '') //获取起始页
                        , hash: 'fenye' //自定义hash值
                        , jump: function (obj, first) {
                            //obj包含了当前分页的所有参数，比如：
                            console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                            console.log(obj.limit); //得到每页显示的条数
                            lastPageSize = obj.limit
                            $(".layui-layer-content").remove()
                            //首次不执行
                            if (!first) {
                                getQuestionMsg(obj.curr, obj.limit);
                            }
                        }
                    });
                }
            }
        });
    }
    getQuestionMsg(1,10)
    // 获取所有汽贸集团
   var startDate= laydate.render({
        elem: '#btime',
        done: function (value, dates) {
            endDate.config.min ={
                year:dates.year,
                month:dates.month-1,
                date: dates.date,
            };
        }});
   var endDate= laydate.render({
        elem: '#etime',
        done: function (value, dates) {
            startDate.config.max={
                year:dates.year,
                month:dates.month-1,
                date: dates.date,
            }
            if($.trim(value) == ''){
                var curDate = new Date();
                date = {'date': curDate.getDate(), 'month': curDate.getMonth(), 'year': curDate.getFullYear()};
                startDate.config.max=date
            }
        }});
})