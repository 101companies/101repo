class CreateDepartments < ActiveRecord::Migration
  def change
    create_table :departments do |t|
      t.string :name
      t.references :company
      t.references :department

      t.timestamps
    end
    add_index :departments, :company_id
    add_index :departments, :department_id
  end
end
