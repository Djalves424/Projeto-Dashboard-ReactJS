import './styles.css';
import SalesSummaryCard from './sales-summary-card';
import avatarIcon from '../../assets/avatar-icon.svg';
import barChartIcon from '../../assets/bar-chart-icon.svg';
import doneIcon from '../../assets/done-icon.svg';
import syncIcon from '../../assets/sync-icon.svg';
import { FilterData, SalesSummaryData } from '../../types';
import { useEffect, useMemo, useState } from 'react';
import { buildFilterParams, makeRequest } from '../../utils/request';

type Props = {
  filterData?: FilterData;
};

const initialSummary = {
  avg: 0,
  count: 0,
  max: 0,
  min: 0
};

function SalesSummary({ filterData }: Props) {
  const [summary, setSummary] = useState<SalesSummaryData>(initialSummary);

  const params = useMemo(() => buildFilterParams(filterData), [filterData]);

  useEffect(() => {
    makeRequest
      .get<SalesSummaryData>('/sales/summary', { params })
      .then((response) => {
        setSummary(response.data);
      })
      .catch(() => {
        console.error('Error to fetch sales summary');
      });
  }, [params]);

  return (
    <div className="sales-summary-container">
      <SalesSummaryCard value={summary?.avg?.toFixed(2)} label="Média" icon={<img src={doneIcon} alt="Done Icon" />} />
      <SalesSummaryCard value={summary?.count} label="Quantidade" icon={<img src={syncIcon} alt="Sync Icon" />} />
      <SalesSummaryCard value={summary?.min} label="Mínima" icon={<img src={barChartIcon} alt="Bar Chart Icon" />} />
      <SalesSummaryCard value={summary?.max} label="Máxima" icon={<img src={avatarIcon} alt="Avatar Icon" />} />
    </div>
  );
}

export default SalesSummary;

// import './styles.css';
// import SalesSummaryCard from './sales-summary-card';
// import { ReactComponent as AvatarIcon } from '../../assets/avatar-icon.svg';
// import { ReactComponent as BarChartIcon } from '../../assets/bar-chart-icon.svg';
// import { ReactComponent as DoneIcon } from '../../assets/done-icon.svg';
// import { ReactComponent as SyncIcon } from '../../assets/sync-icon.svg';
// import { FilterData, SalesSummaryData } from '../../types';
// import { useEffect, useMemo, useState } from 'react';
// import { buildFilterParams, makeRequest } from '../../utils/request';
//
// type Props = {
//   filterData?: FilterData;
// };
//
// const initialSummary = {
//   avg: 0,
//   count: 0,
//   max: 0,
//   min: 0
// };
//
// function SalesSummary({ filterData }: Props) {
//   const [summary, setSummary] = useState<SalesSummaryData>(initialSummary);
//
//   const params = useMemo(() => buildFilterParams(filterData), [filterData]);
//
//   useEffect(() => {
//     makeRequest
//       .get<SalesSummaryData>('/sales/summary', { params })
//       .then((response) => {
//         setSummary(response.data);
//       })
//       .catch(() => {
//         console.error('Error to fetch sales summary');
//       });
//   }, [params]);
//
//   return (
//     <div className="sales-summary-container">
//       <SalesSummaryCard value={summary?.avg?.toFixed(2)} label="Média" icon={<DoneIcon />} />
//       <SalesSummaryCard value={summary?.count} label="Quantidade" icon={<SyncIcon />} />
//       <SalesSummaryCard value={summary?.min} label="Mínima" icon={<BarChartIcon />} />
//       <SalesSummaryCard value={summary?.max} label="Máxima" icon={<AvatarIcon />} />
//     </div>
//   );
// }
//
// export default SalesSummary;


