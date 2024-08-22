import './styles.css';
import SalesSummaryCard from './sales-summary-card';
import AvatarIcon from '../../assets/avatar-icon.svg';
import BarChartIcon from '../../assets/bar-chart-icon.svg';
import DoneIcon from '../../assets/done-icon.svg';
import SyncIcon from '../../assets/sync-icon.svg';

export default function SalesSummary() {
  return (
    <div className="sales-sumamry-container">
      <SalesSummaryCard value={430} label="Média" icon={<DoneIcon />} />
      <SalesSummaryCard value={630} label="Quantidade" icon={<SyncIcon />} />
      <SalesSummaryCard value={130} label="Média" icon={<BarChartIcon />} />
      <SalesSummaryCard value={230} label="Média" icon={<AvatarIcon />} />
    </div>
  );
}


// import './styles.css';
// import SalesSummaryCard from './sales-summary-card';
// import AvatarIcon from '../../assets/avatar-icon.svg';
// import BarChartIcon from '../../assets/bar-chart-icon.svg';
// import DoneIcon from '../../assets/done-icon.svg';
// import SyncIcon from '../../assets/sync-icon.svg';
//
// const summaryData = [
//   { value: 430, label: "Média", icon: DoneIcon },
//   { value: 630, label: "Quantidade", icon: SyncIcon },
//   { value: 130, label: "Média", icon: BarChartIcon },
//   { value: 230, label: "Média", icon: AvatarIcon },
// ];
//
// export default function SalesSummary() {
//   return (
//     <div className="sales-summary-container">
//       {summaryData.map((data, index) => (
//         <SalesSummaryCard
//           key={index}
//           value={data.value}
//           label={data.label}
//           icon={<img src={data.icon} alt={data.label} />}
//         />
//       ))}
//     </div>
//   );
// }
