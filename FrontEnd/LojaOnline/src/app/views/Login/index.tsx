import SocialLogin from "../../components/socialLogin"
import styles from './login.module.scss';
import Logo from "../../../assets/logo-claro.png"
import imageLogin from "../../../assets/image-login.png"

export default function Login(){

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
                    <label htmlFor="email">E-mail</label>
                    <input type="email"/>
                </section>
                <section>
                    <label htmlFor="senha">Senha</label>
                    <input type="password" />
                </section>
                <button className={styles.signButton}>LOGIN</button>
                <a href="/sign">Não possui cadastro?</a>
                <SocialLogin/>
            </div>
        </div>
    )
}