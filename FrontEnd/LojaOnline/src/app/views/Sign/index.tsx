import './style.scss';
import logo from "../../../assets/logo-claro.png"
import imageCadastro from "../../../assets/image-cadastro.png" 

export default function Sign(){

    return(
        <div className="conteiner">
            <div className="sign-content">
                <img src={logo} alt="logo-m-malagu"/>
                <h1>REALIZE O SEU CADASTRO E COMECE A <span> COMPRAR</span></h1>
                <div className="double-input">
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
                <div className="double-input">
                    <section>
                        <label htmlFor="senha">Senha</label>
                        <input type="password" name="senha"/>
                    </section>
                    <section>
                        <label htmlFor="confirm-senha">Confirmar Senha</label>
                        <input type="password" name="confirm-senha"/>
                    </section>
                </div>
                <div className="double-input">
                    <section>
                        <label htmlFor="senha">CPF</label>
                        <input type="text" name="senha"/>
                    </section>
                    <section>
                        <label htmlFor="numero-celular">Numero Celular</label>
                        <input type="text" name="numero-celular"/>
                    </section>
                </div>
                <button>CADASTRAR-SE</button>
                <a href="/login">Já tenho cadastro</a>
                <div className="social-login">
                    <button><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 488 512"><path d="M488 261.8C488 403.3 391.1 504 248 504 110.8 504 0 393.2 0 256S110.8 8 248 8c66.8 0 123 24.5 166.3 64.9l-67.5 64.9C258.5 52.6 94.3 116.6 94.3 256c0 86.5 69.1 156.6 153.7 156.6 98.2 0 135-70.4 140.8-106.9H248v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4z"/></svg></button>
                    <button><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64h98.2V334.2H109.4V256h52.8V222.3c0-87.1 39.4-127.5 125-127.5c16.2 0 44.2 3.2 55.7 6.4V172c-6-.6-16.5-1-29.6-1c-42 0-58.2 15.9-58.2 57.2V256h83.6l-14.4 78.2H255V480H384c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64z"/></svg></button>
                    <button><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"><path d="M318.7 268.7c-.2-36.7 16.4-64.4 50-84.8-18.8-26.9-47.2-41.7-84.7-44.6-35.5-2.8-74.3 20.7-88.5 20.7-15 0-49.4-19.7-76.4-19.7C63.3 141.2 4 184.8 4 273.5q0 39.3 14.4 81.2c12.8 36.7 59 126.7 107.2 125.2 25.2-.6 43-17.9 75.8-17.9 31.8 0 48.3 17.9 76.4 17.9 48.6-.7 90.4-82.5 102.6-119.3-65.2-30.7-61.7-90-61.7-91.9zm-56.6-164.2c27.3-32.4 24.8-61.9 24-72.5-24.1 1.4-52 16.4-67.9 34.9-17.5 19.8-27.8 44.3-25.6 71.9 26.1 2 49.9-11.4 69.5-34.3z"/></svg></button>
                </div>
            </div>
            <div className="sign-image">
                <div className='bg-circle'>
                    <img src={imageCadastro} alt="online-buy-compra" />
                    <p>INVISTA EM QUALIDADE, VOCÊ MERECE O MELHOR!</p>
                </div>
            </div>  
        </div>
    )

}