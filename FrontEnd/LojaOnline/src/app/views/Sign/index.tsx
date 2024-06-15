import logo from "../../../assets/logo-claro.png"
import imageCadastro from "../../../assets/image-cadastro.png" 
import SocialLogin from "../../components/socialLogin"
import styles from "./sign.module.scss"
import { useState } from "react"
import userMutation from "../../services/User/userMudation"
import { IUser } from "../../interfaces/IModalUser"

export default function Sign(){

    const [name, setName] = useState<string>("");
    const [surname, setSurname] = useState<string>("");
    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const [confirmPassword, setConfirmPassword] = useState<string>("");
    const [cpf, setCpf] = useState<string>("");
    const [cel_number, setCel_number] = useState<string>("");
    const { mutate, isSuccess, isError }  = userMutation();

    function handleSignUser(){
        if(name == "" || surname == "" || email == "" || password == "" || confirmPassword == "" || cpf == "" || cel_number == ""){
            alert("TODOS OS CAMPOS DEVEM SER PREENCHIDOS")
        }
        if(password != confirmPassword){
            alert("AS SENHAS INFORMADAS NÃO CONDIZEM")
        }

        const data:IUser = {
            name: name,
            surname: surname,
            email: email,
            password: password,
            cel_number: cel_number,
            CPF: cpf,
            role: "USER",
        }

        mutate(data);

        if(isSuccess){
            alert("USUÁRIO CADASTRADO COM SUCESSO!")
        }if(isError){
            alert("ERRO AO CADASTRAR USUÁRIO")
            console.log(isError.valueOf)
        }

    }

    return(
        <div className={styles.conteinerAuth}>
            <div className={styles.signContent}>
                <img src={logo} alt="logo-m-malagu"/>
                <h1>REALIZE O SEU CADASTRO E COMECE A <span> COMPRAR</span></h1>
                <form action="">
                    <div className={styles.doubleInput}>
                        <section>
                            <label htmlFor="input">
                                <p>Nome</p>
                                <input type="text" value={name} onChange={(e)=>{setName(e.target.value)}}/>
                            </label>
                        </section>
                        <section>
                            <label htmlFor="input">
                                <p>Sobrenome</p>
                                <input type="text" value={surname} onChange={(e)=>{setSurname(e.target.value)}}/>
                            </label>
                        </section>
                    </div>
                        <section>
                            <label htmlFor="input">
                                <p>E-mail</p>
                                <input type="email" value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
                            </label>
                        </section>
                    <div className={styles.doubleInput}>
                        <section>
                            <label htmlFor="input">
                                <p>Senha</p>
                                <input type="password" value={password} onChange={(e)=>{setPassword(e.target.value)}}/>
                            </label>
                        </section>
                        <section>
                            <label htmlFor="input">
                                <p>Confirmar Senha</p>
                                <input type="password" value={confirmPassword} onChange={(e)=>{setConfirmPassword(e.target.value)}}/>
                            </label>
                        </section>
                    </div>
                    <div className={styles.doubleInput}>
                        <section>
                            <label htmlFor="input">
                                <p>CPF</p>
                                <input type="text" value={cpf} onChange={(e)=>{setCpf(e.target.value)}}/>
                            </label>
                        </section>
                        <section>
                            <label htmlFor="numero-celular">
                                <p>Numero Celular</p>
                                <input type="text" value={cel_number} onChange={(e)=>{setCel_number(e.target.value)}}/>
                            </label>
                        </section>
                    </div>
                </form>
                <button className={styles.signButton} onClick={handleSignUser}>CADASTRAR-SE</button>
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