/*
 * boardService 
 * 모듈 구성하기
 * 	
 * 모듈 패턴은 쉽게 말해서 Java의 클래스처럼 JavaScript를 이용해서 메서드를 가지는 
 * 객체를 구성한다. 
 * 모듈 패턴은 JavaScript의 즉시 실행함수와 '{}'를 이용해서 객체를 구성한다. 
 *(함수)() => 함수 바로 실행  
 * 
 * */
 
console.log("테스트 모듈...");
 
var nameService = (function(){

	function dofun(){
		console.log("함수 실행 입니다.")
	}
	
	function didfun(){
		console.log("함수 didfun 입니다.")
	}
		
	return {name : "홍길동",
	        dofun : dofun,
	        didfun : didfun	        
	       };

})();