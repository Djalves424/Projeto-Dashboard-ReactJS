import React from 'react';
import './styles.css';

type Props = {
  value: number | string;
  label: string;
  icon: React.ReactNode;
};

function SalesSummaryCard({ value, label, icon }: Props) {
  return (
    <div className="sales-summary-card base-card">
      {icon}
      <h3 className="sales-summary-card-value">{value}</h3>
      <span className="sales-summary-card-label">{label}</span>
    </div>
  );
}

export default SalesSummaryCard;
