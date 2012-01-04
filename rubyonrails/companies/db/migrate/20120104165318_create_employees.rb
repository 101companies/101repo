class CreateEmployees < ActiveRecord::Migration
  def change
    create_table :employees do |t|
      t.string :name
      t.string :address
      t.float :salary
      t.boolean :isManager
      t.references :department

      t.timestamps
    end
    add_index :employees, :department_id
  end
end
