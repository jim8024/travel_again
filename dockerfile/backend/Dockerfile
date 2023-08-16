
FROM openjdk:11

# 작업 디렉토리 설정
WORKDIR /app

# 백엔드 소스 코드 카피
COPY backend/target/*.jar app.jar

# 포트 열기 
EXPOSE 8080

# 백엔드 실행
CMD ["java", "-jar", "app.jar"]