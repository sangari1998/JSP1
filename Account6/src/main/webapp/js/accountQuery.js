$(document).ready(function(){
    $(".selectMonth1").change(function(){
        var selectedValue = $(this).val();
        if(selectedValue == 1 || selectedValue == 3 || selectedValue == 1 || 
            selectedValue == 7 || selectedValue == 8 || selectedValue == 10 ||
            selectedValue == 12){
                $(".selectDay1").html(`
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                `);
            }
            if(selectedValue == 4 || selectedValue == 6 || selectedValue == 9 || 
                selectedValue == 11){
                    $(".selectDay1").html(`
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                `);
                }
            if(selectedValue == 2){
                $(".selectDay1").html(`
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
            `);            
            }
    });
    $(".selectMonth2").change(function(){
        var selectedValue = $(this).val();
        if(selectedValue == 1 || selectedValue == 3 || selectedValue == 1 || 
            selectedValue == 7 || selectedValue == 8 || selectedValue == 10 ||
            selectedValue == 12){
                $(".selectDay2").html(`
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                `);
            }
            if(selectedValue == 4 || selectedValue == 6 || selectedValue == 9 || 
                selectedValue == 11){
                    $(".selectDay2").html(`
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                `);
                }
            if(selectedValue == 2){
                $(".selectDay2").html(`
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
            `);            
            }
    });
    
    var originalData = {}; // 데이터를 백업할 객체 생성
    
    $(".btn_update").click(function(){
        var currentRow = $(this).closest("tr");
        var rowIndex = currentRow.index();
    
        // 현재 행의 데이터를 백업
        var rowData = {
            'income': currentRow.find("td:eq(1)").text(),
            'money': currentRow.find("td:eq(2)").text(),
            'source': currentRow.find("td:eq(3)").text()
        };
        originalData[rowIndex] = rowData;
    
        // 수정 폼을 표시
        currentRow.find("td:eq(1)").html('<select style="position: relative;top: 5px;" name="source"> <option value="입금">입금</option><option value="income">출금</option></select> ');
        currentRow.find("td:eq(2)").html('<input style="width:120px;" type="text" name="money" required placeholder="변경금액" value="' + rowData.money + '">');
        currentRow.find("td:eq(3)").html('<input style="width:120px;" type="text" name="type" required placeholder="비고변경" value="' + rowData.source + '">');
        $(this).hide(); // 현재 버튼 숨기기
        currentRow.find('.btn_delete').hide(); // 삭제 버튼 숨기기
        currentRow.find('.btn_cancel').show();
        currentRow.find('.btn_update2').show();
    });
    
    $(".btn_cancel").click(function(){
        var currentRow = $(this).closest("tr");
        var rowIndex = currentRow.index();
        var originalRowData = originalData[rowIndex];
    
        if (originalRowData) {
            // 수정을 취소하고 이전 데이터를 복원
            currentRow.find("td:eq(1)").html(originalRowData.income);
            currentRow.find("td:eq(2)").html(originalRowData.money);
            currentRow.find("td:eq(3)").html(originalRowData.source);
            $(this).hide(); // 현재 버튼 숨기기
            currentRow.find('.btn_update2').hide();
            currentRow.find('.btn_update').show();
            currentRow.find('.btn_delete').show(); // 삭제 버튼 표시
        }
    });
    
    $('.btn_update2').on('click', function(){
        var tr = $(this).closest("tr");
        var updateSource = $(this).closest("tr").find("select").val();
        var updateMoney = tr.find("input[name='money']").val();
        var updateType = tr.find("input[name='type']").val();
        if (isNaN(updateMoney)) {
            alert('숫자를 입력해주세요.')
            return;
        } 
        var update = {updateSource,updateMoney,updateType}
        $.ajax({
            url : 'updateAccount',
            data : {"update" : update},
            method : "POST",
            dataType : "JSON",
            success : function(data){
                console.log(data);
                if(data){
                    alert('변경완료되었습니다.');
                }
            },
            error : function(error){
                alert('에러'+error);
            }
        })
    });
});