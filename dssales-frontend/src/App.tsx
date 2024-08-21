import './App.css';
import Filter from "./components/filter";
import Header from "./components/header";
import SalesByDate from './components/sales-by-date';
import SalesSummary from './components/sales-summary'

function App() {

  return (
    <>
      <Header />
      <div className="app-conteiner">
        <Filter />
        <SalesByDate />
        <div className="sales-overview-container">
          <SalesSummary />
        </div>
      </div>
    </>
  );
}

export default App;
