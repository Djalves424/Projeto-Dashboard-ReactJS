import './App.css';
import Filter from "./components/filter";
import Header from "./components/header";
import SalesByDate from './components/sales-by-date';
import SalesSummary from './components/sales-summary';
import PieChartCard from './components/pie-chart-card';
import SalesTable from './components/sales-table';

function App() {

  return (
    <>
      <Header />
      <div className="app-conteiner">
        <Filter />
        <SalesByDate />
        <div className="sales-overview-container">
          <SalesSummary />
          <PieChartCard name="Lojas" labels={['Uberlândia', 'Araguari', 'Uberaba']} series={[40, 30, 30]} />
          <PieChartCard name="Pagamento" labels={['Crédito', 'Débito', 'Dinheiro']} series={[20, 50, 30]} />
        </div>
        <SalesTable />
      </div>
    </>
  );
}

export default App;
