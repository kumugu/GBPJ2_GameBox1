<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>${game.title} | GameBox</title>
    <link rel="stylesheet" href="./resources/css/style.css">
    <link rel="stylesheet" href="./resources/css/shopDetail_style.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="content-container">
    <!-- 상품 상세 정보 -->
    <div class="game-detail">
        <h1>${game.title}</h1>
        <img src="${pageContext.request.contextPath}${game.imagePath}" alt="${game.title}">
   
        <p><strong>장르:</strong> ${game.genre}</p>
        <p><strong>출시일:</strong> ${game.releaseDate}</p>
        <p><strong>개발사:</strong> ${game.developer}</p>
        <p><strong>최근 평가:</strong> ${game.reviewSummary}</p>
        
        <div class="price-cart-container">
            <div class="price-info">
                <span class="discount">-10%</span>
                <span class="current-price">₩${game.price}</span>
            </div>
            <button class="cart-btn" onclick="addToCart('${game.gameId}')">장바구니에 추가</button>
        </div>
        
        <p><strong>설명:</strong> ${game.description}</p>
        <p><strong>최소 사양</strong></p>
        <pre>${game.minRequirements}</pre>
        <p><strong>권장 사양</strong></p>
        <pre>${game.recRequirements}</pre>
    </div>

	<div class="review-section">
	    <h2>리뷰 작성</h2>
	
	    <!-- 로그인한 사용자만 리뷰 작성 가능 -->
	    <c:if test="${not empty sessionScope.user}">
	        <!-- 사용자가 이미 리뷰를 작성한 경우 -->
	        <c:if test="${hasWrittenReview}">
	            <p>이미 리뷰를 작성하셨습니다. 아래에서 수정하거나 삭제할 수 있습니다.</p>
	            <form id="editReviewForm" action="${pageContext.request.contextPath}/manageReview.do" method="post">
	                <textarea name="reviewContent" required>${userReview.content}</textarea>
	                <div class="rating-container">
	                    <label for="rating">평점:</label>
	                    <div class="star-rating">
	                        <c:forEach var="i" begin="1" end="10" step="1">
	                            <input type="radio" name="rating" id="edit-star${10 - i + 1}" value="${10 - i + 1}" <c:if test="${userReview.rating == (10 - i + 1)}">checked</c:if>>
	                            <label for="edit-star${10 - i + 1}" title="${10 - i + 1}점"></label>
	                        </c:forEach>
	                    </div>
	                </div>
	                <input type="hidden" name="action" value="edit">
	                <input type="hidden" name="reviewId" value="${userReview.reviewId}">
	                <input type="hidden" name="gameId" value="${game.gameId}">
	                <button type="submit">리뷰 수정</button>
	            </form>
	            <form id="deleteReviewForm" action="${pageContext.request.contextPath}/manageReview.do" method="post">
	                <input type="hidden" name="action" value="delete">
	                <input type="hidden" name="reviewId" value="${userReview.reviewId}">
	                <input type="hidden" name="gameId" value="${game.gameId}">
	                <button type="submit" class="delete-btn">리뷰 삭제</button>
	            </form>
	        </c:if>
	
	        <!-- 사용자가 아직 리뷰를 작성하지 않은 경우 -->
	        <c:if test="${!hasWrittenReview}">
	            <form id="reviewForm" action="${pageContext.request.contextPath}/manageReview.do" method="post">
	                <textarea name="reviewContent" placeholder="리뷰를 작성해주세요..." required></textarea>
	                <div class="rating-container">
	                    <label for="rating">평점:</label>
	                    <div class="star-rating">
	                        <c:forEach var="i" begin="1" end="10" step="1">
	                            <input type="radio" name="rating" id="star${10 - i + 1}" value="${10 - i + 1}">
	                            <label for="star${10 - i + 1}" title="${10 - i + 1}점"></label>
	                        </c:forEach>
	                    </div>
	                </div>
	                <input type="hidden" name="action" value="write">
	                <input type="hidden" name="gameId" value="${game.gameId}">
	                <button type="submit">리뷰 작성</button>
	            </form>
	        </c:if>
	    </c:if>
	
	    <!-- 로그인하지 않은 경우 -->
	    <c:if test="${empty sessionScope.user}">
	        <p>로그인 후 리뷰를 작성할 수 있습니다.</p>
	    </c:if>
	
	    <h2>리뷰</h2>
		<div class="review-list">
		    <c:forEach var="review" items="${reviews}">
		        <div class="review-item">
		            <p><strong>${review.userName}</strong></p> <!-- 사용자 이름 표시 -->
		            <p>
		                평점: 
		                <span class="star-rating-display">
		                    <c:forEach var="i" begin="1" end="10">
		                        <span class="star <c:if test="${i <= review.rating}">filled</c:if>">★</span>
		                    </c:forEach>
		                </span> (${review.rating} / 10)
		            </p>
		            <p>${review.content}</p>
		            <p><em>${review.createdDate}</em></p>
		        </div>
		    </c:forEach>
		</div>
	</div>

</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
