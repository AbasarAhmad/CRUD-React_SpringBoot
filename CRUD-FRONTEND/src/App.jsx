import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderC from './components/Header.jsx'
import FooterComponent from './components/FooterComponent.jsx'
import AddEmployee from './components/addEmployee.jsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'

function App() {


  return (
    <>
      <BrowserRouter>
        <HeaderC />
        <Routes>
          {/* //http://localhost:3000 */}
          <Route path='/' element={<ListEmployeeComponent />}></Route>
          {/* //http://localhost:3000/employee */}
          <Route path='/employee' element={<ListEmployeeComponent />}></Route>
          {/* //http://localhost:3000/add-employee */}
          <Route path='/add-employee' element={<AddEmployee />}></Route>
          {/* //http://localhost:3000/edit-employee */}
          <Route path='/edit-employee/:id' element={<AddEmployee />}></Route>
        </Routes>

        <FooterComponent />
      </BrowserRouter>


    </>
  )
}
export default App
