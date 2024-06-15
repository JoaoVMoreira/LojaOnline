import { BrowserRouter, Route, Routes } from "react-router-dom"
import Home from "./app/views/Home"
import Sign from "./app/views/Sign"
import Login from "./app/views/Login"
import {QueryClientProvider, QueryClient} from "@tanstack/react-query" 
import { ReactQueryDevtools } from "@tanstack/react-query-devtools"

function App() {

  const client = new QueryClient();

  return (
    <QueryClientProvider client={client}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/sign" element={<Sign/>}/>
        </Routes>
      </BrowserRouter>
      <ReactQueryDevtools initialIsOpen={false}/>
    </QueryClientProvider>
  )
}

export default App
