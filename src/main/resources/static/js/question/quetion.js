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
    $("#addQuestion").bind("click",function () {
        layer.open({
            title: ['新增', 'font-size: 16px; color: rgba(0,0,0,0.85); padding-left: 24px;'],
            type: 2,
            id: 'certificate-box',
            area : ["760px","537px"],
            shadeClose: true,
            btnAlign: 'c',
            content: '../html/admin/addQuestion.html?id=0',
            success: function (layero,index ) {
            }
        })
    })
    function getQuestionMsg(pIndex,pSize) {
        layui.jquery.ajax({
            url: '/question/queryQuestionJsonp',
            type: "POST",
            dataType: "jsonp",
            data: {
                "quesId": $('#quesId').val(),
                "quesType": $('#quesType').val(),
                "subject": $('#subject').val(),
                "currPage":pIndex,
                "pageSize":pSize
            },
            success: function (result) {
                if (result.code == 0) {
                    //第一个实例
                    table.render({
                        elem: '#pageNums_1'
                        , page: false //开启分页
                        , data: result.data
                        , cols: [[ //表头
                            {field: 'quesId', title: '试题ID', width: 100, sort: true, fixed: 'left'}
                            , {field: 'question', title: '<span title="题目">题目</span>', width: 200}
                            , {field: 'answer', title: '<span title="答案1">答案1</span>', width: 180}
                            , {field: 'answer1', title: '<span title="答案2">答案2</span>', width: 180}
                            , {field: 'answer2', title: '<span title="答案3">答案3</span>', width: 180}
                            , {field: 'answer3', title: '<span title="答案4">答案4</span>', width: 180}
                            , {field: 'quesType',title: '<span title="题型">题型</span>', width: 150}
                            , {field: 'subject', title: '<span title="科目">科目</span>', width: 100}
                            , {field: 'keyPoint',  title: '<span title="题目解析">题目解析</span>', width: 180}
                            ,{field: 'sellerName', title: '修改', width: 110,align:'center',
                                templet:function(data) {
                                        return '<a  class="layui-btn layui-btn-xs layui-table-operation-btn" href="javascript:;" lay-event="updateView" >修改</a>';
                                }
                            }
                            ,{field: 'opt',title: '操作',  width: 110, align:'center', toolbar: '#barDemo'}
                        ]]
                        , limits: [10, 15, 20]
                        , limit: pSize //每页默认显示的数量
                    });
                    //监听工具条
                    table.on('tool(pageNums_1)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                        var data = obj.data //获得当前行数据
                            ,layEvent = obj.event; //获得 lay-event 对应的值
                        console.log(data.quesId)
                        console.log(124)
                        if(layEvent === 'del'){
                            layer.confirm('真的删除该题吗？', function(index){
                                layui.jquery.ajax({
                                    url:'/question/deleteQueestion',
                                    type:"POST",
                                    data:{"quesId":data.quesId},
                                    success:function (result) {
                                        if (result.code == 0){
                                            getQuestionMsg(1,10)
                                        }
                                    }
                                });
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                                //向服务端发送删除指令
                            });
                        } else if(layEvent === 'updateView'){
                            layer.confirm("你确定修改这个题目吗？",function (index) {
                                layui.jquery.ajax({
                                    success:function (result) {
                                        var quesId = quesId;
                                        var question = question;
                                        var answer = answer;
                                        var answer1 = answer1;
                                        var answer2 = answer2;
                                        var quesType = quesType;
                                        var keyPoint = keyPoint;
                                        var subject = subject;
                                        layer.open({
                                            title: ['修改试题信息' ,'font-size: 16px; color: rgba(0,0,0,0.85); padding-left: 24px;'],
                                            type: 2,
                                            id: 'certificate-box',
                                            area : ["560px","337px"],
                                            shadeClose: true,
                                            btnAlign: 'c',
                                            content: '../../html/admin/addQuestion.html?id='+quesId,
                                            success: function (layero,index ) {
                                                var framename=$(layero).find("iframe")[0]['name'];
                                                var html="<div class=\"transferVoucher-img-Div\">\n" +
                                                    // "                            <a href=\"{pic}\" target=\"_blank\"><img src=\"{pic}\" width='990px' height='300px' alt=\"驾驶证\"></a>\n" +
                                                    "                            <a href=\"{pic}\" target=\"_blank\">查看</a>\n" +
                                                    "                            <div>{note}</div>\n" +
                                                    "                        </div>";
                                                if(window.frames[framename].document) {
                                                    $(window.frames[framename].document).find("#voucherImgList").empty();
                                                    $(window.frames[framename].document).find("#quesId").html(quesId);
                                                    $(window.frames[framename].document).find("#question").html(question);
                                                    $(window.frames[framename].document).find("#answer").html(answer);
                                                    $(window.frames[framename].document).find("#answer").html(answer);
                                                    $(window.frames[framename].document).find("#answer").html(answer);
                                                    $(window.frames[framename].document).find("#answer").html(answer);
                                                    $(window.frames[framename].document).find("#quesType").html(quesType);
                                                    $(window.frames[framename].document).find("#keyPoint").html(keyPoint);
                                                    $(window.frames[framename].document).find("#subject").html(subject);
                                                    // $(window.frames[framename].document).find("#vinImgUrl").attr("href",vinImgUrl);
                                                }
                                            }
                                        });
                                    }
                                });
                                obj.del(); //修改对应的行（tr）的DOM结构
                                layer.close(index);
                                //向服务器发出更新命令
                            })
                        }
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
                            // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                            // console.log(obj.limit); //得到每页显示的条数
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
    //初始化：
    getQuestionMsg(1,10)
})