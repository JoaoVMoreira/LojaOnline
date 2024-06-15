import SocialLogin from "../../components/socialLogin"
import styles from './login.module.scss';
import Logo from "../../../assets/logo-claro.png"
import imageLogin from "../../../assets/image-login.png"
import { useState } from "react";

export default function Login(){

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

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
                <button className={styles.signButton}>LOGIN</button>
                <a href="/sign">Não possui cadastro?</a>
                <SocialLogin/>
            </div>
        </div>
    )
}