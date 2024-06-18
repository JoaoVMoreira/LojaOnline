import SocialLogin from "../../components/SocialMediasLogin/socialLogin"
import styles from './login.module.scss';
import Logo from "../../../assets/logo-claro.png"
import imageLogin from "../../../assets/image-login.png"
import { useState } from "react";
import { ILogin } from "../../interfaces/IModalUser";
import useLoginMutation from "../../services/User/useLoginMutation";
import { ToastContainer, toast } from "react-toastify";

export default function Login(){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const { mutate, isSuccess, isError, error } = useLoginMutation();

    function handleLogin(){
        const data:ILogin = {
            email: email,
            password: password
        }

        if(email == ''){
            toast.error("É NECESSÁRIO PREENCHER O E-MAIL")
        }
        if(password == ''){
            toast.error("É NECESSÁRIO PREENCHER A SENHA")
        }

        mutate(data);

        if(isSuccess){
            toast.success("LOGIN REALZIADO COM SUCESSO!")
            setTimeout(()=>{
                window.location.href = "/"
            }, 2000)
        }
        if(isError){
            toast.error("Erro ao efetuar login: " + error.message)
            console.log("ERROR: " + error.stack)
        }


    }

    return(
        <div className={styles.conteinerAuth}>
            <ToastContainer/>
            <div className={styles.signImage}>
                <div className={styles.bgCircle}>
                    <img src={imageLogin} alt="buy-compra-online" />
                    <p>INVISTA EM QUALIDADE, VOCÊ MERECE O MELHOR!</p>
                </div>
            </div>
            <div className={styles.signContent}>
                <img src={Logo} alt="logo-malagu-m" />
                <h1>REALIZE O LOGIN E CONTINUE COMPRANDO</h1>
                <section>
                    <label htmlFor="input">
                        <p>E-mail</p>
                        <input type="email" value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
                    </label>
                </section>
                <section>
                    <label htmlFor="input">
                        <p>Senha</p>
                        <input type="password" value={password} onChange={(e)=>{setPassword(e.target.value)}}/>
                    </label>
                </section>
                <button className={styles.signButton} onClick={handleLogin}>LOGIN</button>
                <a href="/sign">Não possui cadastro?</a>
                <SocialLogin/>
            </div>
        </div>
    )
}