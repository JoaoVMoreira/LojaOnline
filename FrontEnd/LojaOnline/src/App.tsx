import { BrowserRouter, Route, Routes } from "react-router-dom"
import Home from "./app/views/Home"
import Sign from "./app/views/Sign"
import Login from "./app/views/Login"

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/sign" element={<Sign/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
