import './styles.css';
import "flatpickr/dist/themes/material_green.css";
import flatpickerLib from 'flatpickr';
import { Portuguese } from 'flatpickr/dist/l10n/pt';
import FlatPicker from 'react-flatpickr';

flatpickerLib.localize(Portuguese);

function Filter() {
  const onChangeDate = (dates: Date[]) => {
    console.log(dates);
  };

  return (
    <div className="filter-conteiner base-card">
      <FlatPicker options={{
        mode: 'range',
        dateFormat: 'd/m/Y',
        showMonths: 2
      }} className="filter-input"
        onChange={onChangeDate}
        placeholder="Selecione um período"
      />
      <select className="filter-input">
        <option value="">Selecione um gênero</option>
        <option value="MALE">Masculino</option>
        <option value="FEMALE">Feminino</option>
        <option value="OTHER">Outro</option>
      </select>
    </div>
  );
}

export default Filter
