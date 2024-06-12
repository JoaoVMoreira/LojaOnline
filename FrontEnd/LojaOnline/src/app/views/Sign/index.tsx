import logo from "../../../assets/logo-claro.png"
import imageCadastro from "../../../assets/image-cadastro.png" 
import SocialLogin from "../../components/socialLogin"
import styles from "./sign.module.scss"

export default function Sign(){

    return(
        <div className={styles.conteinerAuth}>
            <div className={styles.signContent}>
                <img src={logo} alt="logo-m-malagu"/>
                <h1>REALIZE O SEU CADASTRO E COMECE A <span> COMPRAR</span></h1>
                <div className={styles.doubleInput}>
                    <section>
                        <label htmlFor="nome">Nome</label>
                        <input type="text" name="nome"/>
                    </section>
                    <section>
                        <label htmlFor="sobrenome">Sobrenome</label>
                        <input type="text" name="sobrenome"/>
                    </section>
                </div>
                    <section>
                        <label htmlFor="email">E-mail</label>
                        <input type="email"/>
                    </section>
                <div className={styles.doubleInput}>
                    <section>
                        <label htmlFor="senha">Senha</label>
                        <input type="password" name="senha"/>
                    </section>
                    <section>
                        <label htmlFor="confirm-senha">Confirmar Senha</label>
                        <input type="password" name="confirm-senha"/>
                    </section>
                </div>
                <div className={styles.doubleInput}>
                    <section>
                        <label htmlFor="senha">CPF</label>
                        <input type="text" name="senha"/>
                    </section>
                    <section>
                        <label htmlFor="numero-celular">Numero Celular</label>
                        <input type="text" name="numero-celular"/>
                    </section>
                </div>
                <button className={styles.signButton}>CADASTRAR-SE</button>
                <a href="/login">Já tenho cadastro</a>
                <SocialLogin/>
            </div>
            <div className={styles.signImage}>
                <div className={styles.bgCircle}>
                    <img src={imageCadastro} alt="online-buy-compra" />
                    <p>INVISTA EM QUALIDADE, VOCÊ MERECE O MELHOR!</p>
                </div>
            </div>  
        </div>
    )

}