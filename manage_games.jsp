<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>게임 추가</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="./resources/css/admin_manageGames_style.css">
</head>
<body>
    <div class="form-container">
        <h1>게임 추가</h1>
        <form action="addGame" method="post" enctype="multipart/form-data">
            <label for="title">게임 제목:</label>
            <input type="text" id="title" name="title" required>
            
            <label for="image">게임 이미지:</label>
            <input type="file" id="image" name="image" accept="image/*">
            
            <label for="description">게임 설명:</label>
            <textarea id="description" name="description"></textarea>
            
            <label for="genre">장르:</label>
            <select id="genre" name="genre">
                <option value="action">액션</option>
                <option value="puzzle">퍼즐</option>
                <option value="adventure">어드벤처</option>
                <!-- 장르 추가 -->
            </select>
            
            <label for="rating">평점:</label>
            <input type="number" id="rating" name="rating" value="0.0" step="0.1" readonly>
            
            <label for="releaseDate">등록일:</label>
            <input type="date" id="releaseDate" name="releaseDate" required>
            
            <label for="developer">개발자(회사):</label>
            <input type="text" id="developer" name="developer" required>
            
            <label for="price">가격:</label>
            <input type="number" id="price" name="price" step="0.01" required>
            
            <div class="buttons">
                <button type="submit">등록</button>
                <button type="button" onclick="window.location.href='adminPage.jsp'">취소</button>
            </div>
        </form>
    </div>
</body>
</html>
