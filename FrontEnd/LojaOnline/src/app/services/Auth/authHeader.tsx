export const authHeader = () => {
    const token = localStorage.getItem("authtoken");
    if(token){
        return { Authorization: 'Bearer ' + token};
    }else{
        return {};
    }
}