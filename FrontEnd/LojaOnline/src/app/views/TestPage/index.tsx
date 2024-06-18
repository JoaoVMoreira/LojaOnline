import Menu from "../../components/Menu"

export default function Home(){

    return(
        <div>
            <Menu/>
            <h1>
                TESTE PAGE
            </h1>
            <hr />
            <a href="/login">Login</a>
            <hr />
            <a href="/sign">Cadastro</a>
        </div>
    )

}