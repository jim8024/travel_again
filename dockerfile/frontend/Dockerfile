
FROM node:14 as build

# 작업 디렉토리 
WORKDIR /app

# 프론트엔드 소스 코드 
COPY frontend/package*.json ./
RUN npm install
COPY frontend/ ./

# 빌드
RUN npm run build


FROM nginx:1.21

# Nginx 설정 복사
COPY nginx-conf/nginx.conf /etc/nginx/conf.d/default.conf

# 빌드된 프론트엔드 파일 복사
COPY --from=build /app/build /usr/share/nginx/html

# 포트 열기
EXPOSE 80

# Nginx 실행
CMD ["nginx", "-g", "daemon off;"]