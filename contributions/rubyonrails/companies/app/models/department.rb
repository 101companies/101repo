class Department < ActiveRecord::Base
  belongs_to :company
  belongs_to :department
  has_many :departments
  has_many :employees
end
