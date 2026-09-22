
import com.diego.shoping_list.presentation.products.ProductsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductsViewModel() }
}