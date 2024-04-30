/**
 * Created with IntelliJ IDEA.
 *
 * @author ChaseXi
 * @date: 2024/3/13 19:44
 * @Description: 
 */


// 输入框文字限制
const messageInput = document.getElementById('message');
const wordCount = document.getElementById('word-count');
messageInput.addEventListener('input', function() {
    const currentLength = messageInput.value.length;
    wordCount.textContent = currentLength + ' / 200 字';
});

let qqRegExp = /^[1-9]\d{4,11}$/;
//QQ号码验证
$('#qq_number').on('blur', function() {
    let qqNumber = $(this).val();
    if (!qqRegExp.test(qqNumber)) {
        $('#qq_number-error').text('请输入正确的QQ号码');
    }else {
        $('#qq_number-error').text('');
    }
});

$('#qq_number').on('input', function() {
    let qqNumber = $(this).val();
    if (!qqRegExp.test(qqNumber)) {
        $('#qq_number-error').text('请输入正确的QQ号码');
    }else {
        $('#qq_number-error').text('');
    }
});

// 添加点击确认按钮后的处理事件
document.getElementById('confirm-guidelines').addEventListener('click', function() {
    document.getElementById('message-guidelines').classList.add('fade-in'); // 添加淡入动画类名
    document.getElementById('message-guidelines').style.display = 'none'; // 点击确认后隐藏留言内容规范说明
    document.getElementById('contactForm').style.display = 'block'; // 显示留言表单
    $("#message-statement-prompt").html("√您已阅读并同意留言内容规范，请注意您的发言")
    document.getElementById('contactForm').classList.add('fade-in'); // 添加淡入动画类名
});

// 模态框操作部分
let modal = document.getElementById("contact-Modal");
let btn_false = document.getElementById("modal-btn-false");
let btn_true = document.getElementById("modal-btn-true");
btn_false.onclick = function() {
    modal.style.display = "none";
    formError();
    submitMSG(false,"您已经取消了提交");
    resetSubmitTimer()
}
btn_true.onclick = function(e) {
    modal.style.display = "none";
    submitForm()
}
function modal_s(){
    modal.style.display = "block";
}


// 获取本地ip地址
// function getLocalIPAddress() {
//     return new Promise((resolve, reject) => {
//         window.RTCPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
//         const pc = new RTCPeerConnection({iceServers: []});
//         pc.createDataChannel("");
//         pc.createOffer()
//             .then(offer => pc.setLocalDescription(offer))
//             .catch(error => reject(error));
//
//         pc.onicecandidate = event => {
//             if (event.candidate) {
//                 const ipAddress = event.candidate.candidate.split(' ')[4];
//                 resolve(ipAddress);
//                 pc.close();
//             }
//         };
//     });
// }

$("#contactForm").validator().on("submit", function (event) {
    //仅在测试时允许使用，实际环境请删除该段代码（用于重置提交频率限制）
    //----------------------------
    // resetSubmitTimer()
    //----------------------------
    if (event.isDefaultPrevented()) {
        // handle the invalid form...
        formError();
        submitMSG(false, "你把表格填好了吗？");
    }else if($('#qq_number-error').text() !== ''){
        event.preventDefault();
        formError();
        submitMSG(false, "你把表格填好了吗？");
    } else {
        // everything looks good!
        event.preventDefault();
        const remainingTime = getRemainingTime();
        if(remainingTime <= 0){
            submitMSG(false, "提交询问中...");
            modal_s();
        }else {
            submitMSG(false, "您提交的太频繁了，请您等待 " + formatTime(remainingTime) + " 后再提交");
        }
        // submitForm();
    }
});


function submitForm(){
    // Initiate Variables With Form Content
    let message_statement = $("#message-statement-prompt").text();
    if(message_statement !== "√您已阅读并同意留言内容规范，请注意您的发言"){
        formError();
        submitMSG(false, "请先阅读并同意留言内容规范");
        return false;
    }

    let submitMethod = $("input[name='submitMethod']:checked").val(); // 获取选择的提交方式
    let _submitMethod;
    if(submitMethod === "database"){
        _submitMethod = 1;
    }else if(submitMethod === "email"){
        _submitMethod = 2;
    }else {
        formError();
        submitMSG(false, "请选择提交方式");
        return false;
    }

    let qq_number = $("#qq_number").val();
    //进行正则表达式验证
    if(!qq_number.match(/^[1-9]\d{4,11}$/)){
        formError();
        submitMSG(false, "请输入正确的QQ号");
        return false;
    }
    let qq_name = $("#qq_name").val();
    let game_name = $("#game_name").val();
    let message = $("#message").val();
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, '0');
    const day = String(currentDate.getDate()).padStart(2, '0');
    const hours = String(currentDate.getHours()).padStart(2, '0');
    const minutes = String(currentDate.getMinutes()).padStart(2, '0');
    const seconds = String(currentDate.getSeconds()).padStart(2, '0');
    const formattedDate = year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
    $.ajax({
        type: "POST",
        url: "submitMessage",
        data: {
            "qq_number" : qq_number,
            "qq_name" : qq_name,
            "game_name" : game_name,
            "message" : message,
            "messageTime" : formattedDate,
            "submitMethod" : _submitMethod
        },
        success : function(data){
            if (data === "1"){
                formSuccess();
            } else {
                formError();
                submitMSG(false,"发生了一些问题，导致提交失败了");
            }
        }
    });
    // getLocalIPAddress()
    //     .then(ipAddress => {
    //     })
    //     .catch(error => {
    //         alert("获取ip失败\n\n" + error)
    //     });
}

function formSuccess(){
    $("#contactForm")[0].reset();
    submitMSG(true, "提交成功！")
}

function formError(){
    $("#contactForm").removeClass().addClass('shake animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
        $(this).removeClass();
    });
}

function submitMSG(valid, msg){
    let msgClasses = "";
    if(valid){
        msgClasses = "h3 text-left tada animated text-success";
    } else {
        msgClasses = "h3 text-left text-danger";
    }
    $("#msgSubmit").removeClass().addClass(msgClasses).text(msg);
}

// 防止重复提交（设置为每10分钟允许提交一次）（返回true/false）
// function canSubmit() {
//     const lastSubmitTime = localStorage.getItem("lastSubmitTime");
//     if (lastSubmitTime) {
//         const currentTime = new Date();
//         const diff = currentTime - new Date(lastSubmitTime);
//         const minutesPassed = Math.floor(diff / 600); // 转换为分钟
//         if (minutesPassed >= 10) {
//             localStorage.setItem("lastSubmitTime", currentTime);
//             return true;
//         } else {
//             return false;
//         }
//     } else {
//         const currentTime = new Date();
//         localStorage.setItem("lastSubmitTime", currentTime);
//         return true;
//     }
// }

// 防止重复提交（设置为每10分钟允许提交一次）（返回剩余时间）
function getRemainingTime() {
    const lastSubmitTime = localStorage.getItem("lastSubmitTime");
    if (lastSubmitTime) {
        const currentTime = new Date();
        const diff = currentTime - new Date(lastSubmitTime);
        const secondsPassed = Math.floor(diff / 1000); // 转换为秒

        if (secondsPassed >= 300) { // 5分钟 = 300秒
            localStorage.setItem("lastSubmitTime", currentTime);
            return 0; // 可以立即提交
        } else {
            return 600 - secondsPassed;
        }
    } else {
        const currentTime = new Date();
        localStorage.setItem("lastSubmitTime", currentTime);
        return 0; // 可以立即提交
    }
}

// 重置提交时间
function resetSubmitTimer() {
    localStorage.removeItem("lastSubmitTime");
}

// 剩余时间格式划
function formatTime(seconds) {
    const minutes = Math.floor(seconds / 60);
    const remainingSeconds = seconds % 60;
    return `${minutes} 分钟 ${remainingSeconds} 秒`;
}
