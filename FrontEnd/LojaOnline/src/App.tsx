import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom"
import Home from "./app/views/Home"
import Sign from "./app/views/Sign"
import Login from "./app/views/Login"
import {QueryClientProvider, QueryClient} from "@tanstack/react-query" 
import { ReactQueryDevtools } from "@tanstack/react-query-devtools"
import { FC } from "react"

function App() {

  const client = new QueryClient();

  interface PrivateRouteProps {
    element: React.ComponentType<any>;
  }
  
  const PrivateRoute: FC<PrivateRouteProps> = ({ element: Element }) => {
    return localStorage.getItem('authToken') ? <Element /> : <Navigate to="/login" />;
  };

  const InativateRoute: FC<PrivateRouteProps> = ({element: Element}) => {
    return localStorage.getItem('authToken') ? <Navigate to="/" /> : <Element/>;
  }

  return (
    <QueryClientProvider client={client}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<PrivateRoute element={Home}/>}/>
          <Route path="/login" element={<InativateRoute element={Login}/>}/>
          <Route path="/sign" element={<InativateRoute element={Sign}/>}/>
        </Routes>
      </BrowserRouter>
      <ReactQueryDevtools initialIsOpen={false}/>
    </QueryClientProvider>
  )
}

export default App
