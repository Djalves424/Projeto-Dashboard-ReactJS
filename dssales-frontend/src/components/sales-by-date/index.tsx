import './styles.css';
import ReactApexChart from 'react-apexcharts';
import { buildChartSeries, chartOptions, sumSalesByDate } from './helpers'
import { useEffect, useState } from 'react';
import { makeRequest } from '../../utils/request';
import { ChartSeriesData, FilterData, SalesByDate } from '../../types';
import { formatPrice } from '../../utils/formatters';

type Props = {
  filterData?: FilterData;
};

  function SalesByDateComponent({ filterData }: Props)  {
  const [chartSeries, setChartSeries] = useState<ChartSeriesData[]>([]);
  const [totalSum, setTotalSum] = useState(0);

  useEffect(() => {
    makeRequest.get<SalesByDate[]>('/sales?page=0&size=12&sort=date,desc&minDate=2017-01-01&maxDate=2017-01-31&gender=FEMALE').then((response) => {
      const newChartSeries = buildChartSeries(response.data);
      setChartSeries(newChartSeries);
      const newTotalSum = sumSalesByDate(response.data);
        setTotalSum(newTotalSum);
    });
  }, []);

  return (
    <div className="sales-by-date-conteiner base-card" >
      <div>
        <h4 className="sales-by-date-title"> Evolução das vendas </h4>
        <span className="sales-by-date-period">{filterData?.dates?.[0].toISOString()}</span>
      </div>
      <div className="sales-by-date-data">
        <div className="sales-by-date-quantity-container">
          <h2 className="sales-by-date-quantity">{formatPrice(totalSum)}</h2>
          <span className="sales-by-date-quantity-label">Vendas no período</span>
          <span className="sales-by-date-quantity-description">O gráfico mostra as vendas em todas as lojas</span>
        </div>
        <div className="sales-by-date-chart">
          <ReactApexChart options={chartOptions} series={[{ name: 'Vendas', data: chartSeries }]} type="bar" height={240} width="100%" />
        </div>
      </div>
    </div>
  );
}

export default SalesByDateComponent
