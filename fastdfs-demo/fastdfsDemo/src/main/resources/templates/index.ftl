<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>uploading file</title>
</head>
<body>
    <form action="/demo/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="username" placeholder="username"/>
        <input type="file" placeholder="choose file" name="file"/>
        <img  alt="点击切换" src="/kaptcha" onclick="changeImg(this)">
        <input type="text" placeholder="verifyCode" name="verifyCodeActual"/>
        <input type="submit" value="ok"/>
    </form>
</body>
<script>
    function changeImg(img) {

        img.src = "../kaptcha?" + Math.floor(Math.random() * 100);
    }
</script>
</html>