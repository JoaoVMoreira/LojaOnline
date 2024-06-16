import SocialLogin from "../../components/socialLogin"
import styles from './login.module.scss';
import Logo from "../../../assets/logo-claro.png"
import imageLogin from "../../../assets/image-login.png"
import { useState } from "react";
import { ILogin } from "../../interfaces/IModalUser";
import useLoginMutation from "../../services/User/useLoginMutation";
import { useNavigate } from "react-router-dom";

export default function Login(){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const { mutate, isSuccess, isError, error } = useLoginMutation();
    const navigate = useNavigate();

    function handleLogin(){
        const data:ILogin = {
            email: email,
            password: password
        }

        mutate(data);

        if(isSuccess){
            alert("LOGIN REALZIADO COM SUCESSO!");
            navigate("/")
        }
        if(isError){
            alert("ERRO AO EFETUAR LOGIN")
            console.log("ERROR: " + error.stack)
        }


    }

    return(
        <div className={styles.conteinerAuth}>
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