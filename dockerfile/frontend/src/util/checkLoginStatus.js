// 사용자가 로그인한 경우
export function setLoggedIn() {
    sessionStorage.setItem('isLoggedIn', 'true');
}

// 사용자가 로그아웃한 경우
export function setLoggedOut() {
    sessionStorage.removeItem('isLoggedIn');
}

// 로그인 상태 확인 함수
export function checkLoggedIn() {
    return sessionStorage.getItem('isLoggedIn') === 'true';
}
