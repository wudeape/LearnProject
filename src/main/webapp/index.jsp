<html>
<body>
<h2>Hello World!</h2>
</body>

<script>
    function printPtRecord() {
        var checkflag = checkRecordIsexist();
        if (checkflag == "0") {
            MsgBox.warning("没有此条透析记录，请先新建透析记录！");
            return;
        }

        var LODOP;
        LODOP = getLodop();
        LODOP.PRINT_INIT("打印透析治疗单账票");
        Ajax.ajax({
            url: CONTEXT_ROOT + "",
            data: {
            },
            success: function (data) {
                if (data.successCount == 0) {
                    var strHTML = data.retMsg;
                    console.log(strHTML);
                    //头部内容
                    var topStr = strHTML.match(/\<lotustop\>([\s\S]*?)\<\/lotustop\>/)[1];
                    //尾部内容
                    var bottomStr = strHTML.match(/\<lotusbottom\>([\s\S]*?)\<\/lotusbottom\>/)[1];
                    //主体内容
                    var contentstr = strHTML.replace(/\<lotustop\>([\s\S]*?)\<\/lotustop\>/g, "").replace(/\<lotusbottom\>([\s\S]*?)\<\/lotusbottom\>/g, "");

                    //ADD_PRINT_HTM(Top,Left,Width,Height,strHtmlContent)
                    LODOP.ADD_PRINT_HTM('20mm', 0, '100%', 'BottomMargin:10mm', contentstr);
                    LODOP.SET_PRINT_STYLEA(0, "Vorient", 3);//设置当前内容项垂直方向的位置锁定方式

                    LODOP.ADD_PRINT_HTM(0, 0, '100%', '20mm', topStr);
                    LODOP.SET_PRINT_STYLEA(0, "ItemType", 1);//设定打印项的基本属性：ItemType：1--表示页眉页脚

                    LODOP.ADD_PRINT_HTM('275mm', 0, '100%', '10mm', bottomStr);
                    LODOP.SET_PRINT_STYLEA(0, "ItemType", 1);

                    LODOP.PREVIEW();
                } else {
                    MsgBox.warning(data.retMsg);
                }
            }
        });

    }
</script>
</html>
