export interface IUser{
    email: string,
    password: string, 
    name: string,
    surname: string, 
    CPF: string,
    cellNumber: string, 
    role: string
}

export interface ILogin{
    email: string,
    password: string
}