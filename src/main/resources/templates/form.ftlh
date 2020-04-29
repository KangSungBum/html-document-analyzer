<#setting number_format="computer">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sungbum Kang</title>
</head>
<body>
<form action="/document" method="post">
    URL:<br>
    <input type="text" name="url" value="${url!''}">
    <br><br>
    Type:<br>
    <label>
        <select name="type">
            <option value="removeTags" <#if type?? && type = 'removeTags'>selected</#if>>HTML 태그 제외
            </option>
            <option value="all" <#if type?? && type = 'all'>selected</#if>>TXT 전체</option>
        </select>
    </label>
    <br><br>
    출력묶음 단위(자연수):<br>
    <label>
        <input type="text" name="divider" value="${divider!''}">
    </label>
    <br><br>
    <input type="submit" value="출력">
</form>
<#if remainder?? >
    몫: ${quotient}<br>
    나머지: ${remainder}<br>
</#if>
<#if exceptionMessage?? >
    ${exceptionMessage}
</#if>
<script src="/js/main.js"></script>
</body>
</html>
