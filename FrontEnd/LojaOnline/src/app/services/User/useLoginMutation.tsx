import axios from "axios"
import { ILogin } from "../../interfaces/IModalUser"
import { useMutation } from "@tanstack/react-query"

export default function useLoginMutation(){
    const API_REQUEST = "http://localhost:8080/auth"

    const postData = async (data:ILogin) => {
        return await axios.post(API_REQUEST + "/login", data)
    } 

    const loginMutate = useMutation({
        mutationFn: postData,
        onSuccess: (token) => {
            localStorage.setItem("authToken", token.data.token)
        }
    }) 

    return loginMutate;
}