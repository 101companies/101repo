using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using csharpBaseline;
using csharpBaseline.CompanyModel;

namespace csharpAspNetMvc.Controllers
{
    public class DepartmentController : Controller
    {
        //
        // GET: /Department/

        public ActionResult Index(Guid id)
        {
            var dept = CompanyRepository.CreateInMemoryModel().AllDepartments.Where(d => d.Id == id).Single();
            return View(dept);
        }

    }
}
