import axios from "axios"
import { IUser } from "../../interfaces/IModalUser"
import { useMutation } from "@tanstack/react-query";

export default function userMutation(){

    const API_REQUEST = "http://localhost:8080/auth"
    
    const postUserData = async (data:IUser) => {
        return await axios.post(API_REQUEST + "/register", data);
    }

    const userMutate = useMutation({
        mutationFn: postUserData
    })

    return userMutate;

}