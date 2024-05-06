/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @date: 2024/5/6 10:15
 * @Description:
 * @version 1.0
 */
function getDateTime() {
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, '0');
    const day = String(currentDate.getDate()).padStart(2, '0');
    const hours = String(currentDate.getHours()).padStart(2, '0');
    const minutes = String(currentDate.getMinutes()).padStart(2, '0');
    const seconds = String(currentDate.getSeconds()).padStart(2, '0');
    return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
}